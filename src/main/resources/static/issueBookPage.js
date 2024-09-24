function issueBook() {
	const selectedBook = document.querySelector('input[name="issue"]:checked');

	if (selectedBook) {
		const selectedId = parseInt(selectedBook.value, 10);
		const url = `/issueBookById?id=${selectedId}`;
		fetch(url, {
			method: 'GET'
		})
			.then(response => {
				if (response.ok) {
					return response.text();
				} else {
					throw new Error('Failed to issue the book.');
				}
			})
			.then(message => {
				alert(message);
				window.location.href = '/home';
			})
			.catch(error => {
				console.error('Error:', error);
				alert('An error occurred: ' + error.message);
			});
	} else {
		alert('No book selected for issuing.');
	}
}
