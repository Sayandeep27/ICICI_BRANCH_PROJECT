let sections = [];

async function loadSections() {
  const token = localStorage.getItem("jwt");
  if (!token) return window.location.href = "index.html";

  const res = await fetch("/api/checklist-sections", {
    headers: { Authorization: `Bearer ${token}` },
  });
  sections = await res.json();

  const sectionDropdown = document.getElementById("sectionDropdown");
  sectionDropdown.innerHTML = `<option value="">Select Section</option>`;
  sections.forEach(sec => {
    sectionDropdown.innerHTML += `<option value="${sec.section}">${sec.section}</option>`;
  });
}

function loadCategories() {
  const sectionName = document.getElementById("sectionDropdown").value;
  const section = sections.find(s => s.section === sectionName);
  const categoryDropdown = document.getElementById("categoryDropdown");
  categoryDropdown.innerHTML = "";

  if (section && section.categories) {
    section.categories.forEach(cat => {
      categoryDropdown.innerHTML += `<option value="${cat.title}">${cat.title}</option>`;
    });
  }
}

function showReviewPopup() {
  document.getElementById("reviewPopup").classList.remove("hidden");
}

function closePopup() {
  document.getElementById("reviewPopup").classList.add("hidden");
}

async function submitReview() {
  const branchId = localStorage.getItem("selectedBranchId");
  const section = document.getElementById("sectionDropdown").value;
  const category = document.getElementById("categoryDropdown").value;
  const remarks = document.getElementById("remarks").value;
  const file = document.getElementById("photoUpload").files[0];

  if (!file) return alert("Please upload a photo");

  const reader = new FileReader();
  reader.onloadend = async () => {
    const photoBase64 = reader.result;

    const res = await fetch("/api/review", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
      body: JSON.stringify({ branchId, section, category, remarks, photoBase64 }),
    });

    if (res.ok) {
      alert("Review submitted successfully!");
      window.location.href = "success.html";
    } else {
      alert("Error submitting review.");
    }
  };
  reader.readAsDataURL(file);
}

loadSections();
