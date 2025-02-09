document.addEventListener("DOMContentLoaded", function () {
    const toggleThemeBtn = document.getElementById("toggle-theme");
    const body = document.body;

    // Verifica se o usuário já ativou o modo escuro antes
    const darkMode = localStorage.getItem("darkMode");

    if (darkMode === "enabled") {
        body.classList.add("dark-mode");
        toggleThemeBtn.textContent = "Modo Claro";
    }

    toggleThemeBtn.addEventListener("click", function () {
        body.classList.toggle("dark-mode");

        if (body.classList.contains("dark-mode")) {
            localStorage.setItem("darkMode", "enabled");
            toggleThemeBtn.textContent = "Modo Claro";
        } else {
            localStorage.setItem("darkMode", "disabled");
            toggleThemeBtn.textContent = "Modo Escuro";
        }
    });
});
