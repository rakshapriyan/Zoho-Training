// DOM Elements
const transferTypeInputs = document.querySelectorAll('input[name="transferType"]');
const transferToOtherFields = document.getElementById('transferToOtherFields');
const sameBankInputs = document.querySelectorAll('input[name="sameBank"]');
const differentBankFields = document.getElementById('differentBankFields');

// Toggle "Transfer to Other Account" Section
transferTypeInputs.forEach(input => {
    input.addEventListener('change', () => {
        if (input.value === 'other') {
            transferToOtherFields.classList.remove('hidden');
        } else {
            transferToOtherFields.classList.add('hidden');
        }
    });
});

// Toggle "Different Bank" Fields
sameBankInputs.forEach(input => {
    input.addEventListener('change', () => {
        if (input.value === 'no') {
            differentBankFields.classList.remove('hidden');
        } else {
            differentBankFields.classList.add('hidden');
        }
    });
});

// Handle Form Submission (Mock Data)
document.getElementById('transferForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(this);
    const data = Object.fromEntries(formData.entries());

    console.log('Form Data:', data);
    alert('Transfer request submitted successfully!');
});
