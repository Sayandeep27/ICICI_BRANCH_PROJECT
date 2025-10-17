let sections = ["Outside", "Inside", "ATM Lobby"]; // Static sections for dropdown
let currentSectionData = null;

// ✅ Load section dropdown
function loadSections() {
  const token = localStorage.getItem("jwt");
  if (!token) {
    window.location.href = "index.html";
    return;
  }

  const sectionDropdown = document.getElementById("sectionDropdown");
  sectionDropdown.innerHTML = `<option value="">Select Section</option>`;
  sections.forEach(sec => {
    sectionDropdown.innerHTML += `<option value="${sec}">${sec}</option>`;
  });
}

// ✅ Fetch categories for selected section dynamically
async function loadCategories() {
  const sectionName = document.getElementById("sectionDropdown").value;
  const token = localStorage.getItem("jwt");

  if (!sectionName) return;

  const res = await fetch(`/api/checklist/${encodeURIComponent(sectionName)}`, {
    headers: { Authorization: `Bearer ${token}` },
  });

  if (!res.ok) {
    alert("Error loading categories for section: " + sectionName);
    return;
  }

  currentSectionData = await res.json();

  const categoryDropdown = document.getElementById("categoryDropdown");
  categoryDropdown.innerHTML = `<option value="">Select Category</option>`;

  if (currentSectionData && currentSectionData.categories) {
    currentSectionData.categories.forEach(cat => {
      categoryDropdown.innerHTML += `<option value="${cat.title}">${cat.title}</option>`;
    });
  }
}

// ✅ Show popup for review
function showReviewPopup() {
  document.getElementById("reviewPopup").classList.remove("hidden");
}

// ✅ Close popup
function closePopup() {
  document.getElementById("reviewPopup").classList.add("hidden");
}

// ✅ Submit review for selected category
async function submitReview() {
  const branchId = localStorage.getItem("selectedBranchId");
  const section = document.getElementById("sectionDropdown").value;
  const category = document.getElementById("categoryDropdown").value;
  const remarks = document.getElementById("remarks").value;
  const file = document.getElementById("photoUpload").files[0];

  if (!branchId || !section || !category || !file) {
    alert("Please fill all fields and upload a photo.");
    return;
  }

  const reader = new FileReader();
  reader.onloadend = async () => {
    const photoBase64 = reader.result;

    const res = await fetch("/api/review", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${localStorage.getItem("jwt")}`,
      },
      body: JSON.stringify({
        branchId,
        section,
        category,
        remarks,
        photoBase64,
      }),
    });

    if (res.ok) {
      alert("Review submitted successfully!");
      window.location.href = "success.html";
    } else {
      const msg = await res.text();
      alert("Error submitting review: " + msg);
    }
  };

  reader.readAsDataURL(file);
}

// ✅ Initialize page
document.addEventListener("DOMContentLoaded", loadSections);
