// Mock transaction data
const transactions = [
    { date: "2024-10-01", id: "TX12345", description: "Amazon Purchase", amount: 500, type: "debit" },
    { date: "2024-10-03", id: "TX12346", description: "Salary Credit", amount: 5000, type: "credit" },
    { date: "2024-10-05", id: "TX12347", description: "Electricity Bill", amount: 1200, type: "debit" },
];

// Populate transaction table
function populateTable(data) {
    const tbody = document.getElementById("transaction-data");
    tbody.innerHTML = "";

    data.forEach(txn => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${txn.date}</td>
            <td>${txn.id}</td>
            <td>${txn.description}</td>
            <td>${txn.amount > 0 ? "+" : ""}${txn.amount}</td>
            <td>${txn.type}</td>
        `;
        tbody.appendChild(row);
    });
}

// Apply filters
document.getElementById("apply-filters").addEventListener("click", () => {
    const creditFilter = document.getElementById("filter-credit").checked;
    const debitFilter = document.getElementById("filter-debit").checked;

    let filtered = transactions;

    if (creditFilter) filtered = filtered.filter(txn => txn.type === "credit");
    if (debitFilter) filtered = filtered.filter(txn => txn.type === "debit");

    populateTable(filtered);
});

// Load transactions on page load
document.addEventListener("DOMContentLoaded", () => {
    populateTable(transactions);
});
