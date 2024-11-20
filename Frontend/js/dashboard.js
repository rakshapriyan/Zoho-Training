
        // Mock data for accounts and transactions
        const sampleData = {
            accounts: [
                { id: "savings", name: "Savings Account - 1234", balance: 30000 },
                { id: "current", name: "Current Account - 5678", balance: 20000 },
            ],
            transactions: [
                { date: "2024-11-01", account: "savings", description: "ATM Withdrawal", amount: 5000, type: "Debit" },
                { date: "2024-10-28", account: "current", description: "Salary Credit", amount: 25000, type: "Credit" },
                { date: "2024-10-25", account: "savings", description: "Online Shopping", amount: 3000, type: "Debit" }
            ]
        };

        // Function to calculate the total credited and debited amounts in the last 10 days
        function calculateRecentTransactionsSummary() {
            const today = new Date();
            const tenDaysAgo = new Date(today);
            tenDaysAgo.setDate(today.getDate() - 10);

            let totalCredited = 0;
            let totalDebited = 0;

            sampleData.transactions.forEach(txn => {
                const txnDate = new Date(txn.date);
                if (txnDate >= tenDaysAgo) {
                    if (txn.type === "Credit") {
                        totalCredited += txn.amount;
                    } else if (txn.type === "Debit") {
                        totalDebited += txn.amount;
                    }
                }
            });

            // Update the total credited and debited amounts on the page
            document.getElementById("total-credited").textContent = totalCredited;
            document.getElementById("total-debited").textContent = totalDebited;
        }

        // Component: Account Selector with search functionality
        function AccountSelector() {
            const container = document.getElementById("account-selector");
            const selectBox = document.createElement("select");
            selectBox.id = "account-select";
            const searchInput = document.createElement("input");
            searchInput.type = "text";
            searchInput.id = "account-search";
            searchInput.placeholder = "Search Account...";
            searchInput.classList.add("search-bar");

            // Create the options for account select
            const defaultOption = document.createElement("option");
            defaultOption.value = "all";
            defaultOption.textContent = "All Accounts";
            selectBox.appendChild(defaultOption);

            // Add event listener for search
            searchInput.addEventListener("input", filterAccounts);

            // Populate the accounts list
            sampleData.accounts.forEach(account => {
                const option = document.createElement("option");
                option.value = account.id;
                option.textContent = account.name;
                selectBox.appendChild(option);
            });

            // Append elements to container
            container.appendChild(searchInput);
            container.appendChild(selectBox);

            selectBox.addEventListener("change", updateDashboard);
        }

        // Filter accounts based on search input
        function filterAccounts() {
            const searchTerm = document.getElementById("account-search").value.toLowerCase();
            const selectBox = document.getElementById("account-select");
            const options = selectBox.getElementsByTagName("option");

            Array.from(options).forEach(option => {
                if (option.textContent.toLowerCase().includes(searchTerm)) {
                    option.style.display = "block";
                } else {
                    option.style.display = "none";
                }
            });
        }

        // Function to update the dashboard with account and transaction details
        function updateDashboard() {
            const selectedAccountId = document.getElementById("account-select").value;
            const accountDetails = sampleData.accounts.find(account => account.id === selectedAccountId);

            // Show account details
            const accountDetailsCard = document.getElementById("account-details");
            if (accountDetails) {
                accountDetailsCard.innerHTML = `
                    <h3>Account: ${accountDetails.name}</h3>
                    <p><strong>Balance:</strong> ₹${accountDetails.balance}</p>
                `;
                accountDetailsCard.style.display = "block";
            } else {
                accountDetailsCard.style.display = "none";
            }

            // Update recent transactions
            const transactionsTable = document.getElementById("transactions-table");
            transactionsTable.innerHTML = "";

            let filteredTransactions = sampleData.transactions;
            if (selectedAccountId !== "all") {
                filteredTransactions = sampleData.transactions.filter(txn => txn.account === selectedAccountId);
            }

            filteredTransactions.forEach(txn => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${txn.date}</td>
                    <td>${txn.account}</td>
                    <td>${txn.description}</td>
                    <td>₹${txn.amount}</td>
                    <td>${txn.type}</td>
                `;
                transactionsTable.appendChild(row);
            });

            // Calculate and display total credited and debited amounts
            calculateRecentTransactionsSummary();
        }

        // Initialize the dashboard on page load
        function initializeDashboard() {
            AccountSelector();
            updateDashboard();
        }

        // Call initializeDashboard when the page is ready
        window.onload = initializeDashboard;