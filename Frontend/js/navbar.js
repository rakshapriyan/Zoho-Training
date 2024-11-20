// Mock user role (change for testing: 'customer', 'manager', 'employee')
const userRole = 'customer';

// Navbar links based on role
const navLinks = {
    customer: [
        { text: "Dashboard", href: "#" },
        { text: "Transfer", href: "#" },
        { text: "Transactions", href: "#" },
        {
            text: "Accounts",
            type: "dropdown",
            options: [
                { text: "Savings Account", href: "#" },
                { text: "Current Account", href: "#" },
            ],
        },
        { text: "Notification", href: "#" },
    ],
    manager: [
        { text: "Dashboard", href: "#" },
        { text: "Transfer", href: "#" },
        { text: "Employee Details", href: "#" },
        { text: "Account Details", href: "#" },
        { text: "Transactions", href: "#" },
        { text: "Notification", href: "#" },
    ],
    employee: [
        { text: "Dashboard", href: "#" },
        { text: "Transfer", href: "#" },
        { text: "Account Details", href: "#" },
        { text: "Transactions", href: "#" },
        { text: "Notification", href: "#" },
    ],
};

// Function to build the navigation menu
function buildNavbar(links) {
    const navContainer = document.getElementById("nav-links");
    navContainer.innerHTML = ""; // Clear existing links

    links.forEach(link => {
        if (link.type === "dropdown") {
            // Create dropdown
            const dropdown = document.createElement("li");
            dropdown.classList.add("dropdown");

            const dropdownToggle = document.createElement("a");
            dropdownToggle.classList.add("dropdown-toggle");
            dropdownToggle.textContent = link.text;

            const dropdownMenu = document.createElement("div");
            dropdownMenu.classList.add("dropdown-menu");

            link.options.forEach(option => {
                const optionLink = document.createElement("a");
                optionLink.href = option.href;
                optionLink.textContent = option.text;
                dropdownMenu.appendChild(optionLink);
            });

            dropdown.appendChild(dropdownToggle);
            dropdown.appendChild(dropdownMenu);
            navContainer.appendChild(dropdown);
        } else {
            // Create regular link
            const navItem = document.createElement("li");
            const navLink = document.createElement("a");
            navLink.href = link.href;
            navLink.textContent = link.text;
            navItem.appendChild(navLink);
            navContainer.appendChild(navItem);
        }
    });
}

// Initialize navbar
buildNavbar(navLinks[userRole]);
