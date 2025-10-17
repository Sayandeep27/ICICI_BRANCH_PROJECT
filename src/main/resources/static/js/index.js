async function generateToken() {
  const mobile = document.getElementById("mobile").value.trim();
  if (!mobile) return alert("Please enter your phone number");

  const response = await fetch("/auth/token", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ mobile }),
  });

  if (response.ok) {
    const data = await response.json();
    localStorage.setItem("jwt", data.token);
    window.location.href = "branch.html";
  } else {
    alert("Failed to generate token");
  }
}
