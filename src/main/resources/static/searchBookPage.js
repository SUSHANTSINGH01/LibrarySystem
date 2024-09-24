function searchBook() {
	const titleInput = document.getElementById('searchInput');
	if (titleInput) {
		const searchTitle = titleInput.value;
		const url = `/searchBookByTitle?title=${encodeURIComponent(searchTitle)}`;
		fetch(url, {
			method: 'GET'
		})
			.then(response => {
				if (response.ok) {
					return response.json();
				} else if (response.status === 404) {
					alert("Book not found.");
					window.location.href = '/searchBook';
				} else {
					throw new Error('Failed to retrieve the book.');
				}
			})
			.then(book => {
				if (book && book.id) {
					renderBookDetails(book);
				}
			})
			.catch(error => {
				console.error('Error:', error);
				alert('An error occurred: ' + error.message);
			});
	} else {
		alert('No book title entered for searching.');
	}
}


function renderBookDetails(book) {
	const tableBody = document.querySelector('#showBook tbody');
	tableBody.innerHTML = '';
	const row = document.createElement('tr');
	row.innerHTML = `
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
    `;
	tableBody.appendChild(row);
}

