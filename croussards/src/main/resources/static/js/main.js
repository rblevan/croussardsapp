document.addEventListener('DOMContentLoaded', () => {
    fetchRestaurants();
});

function fetchRestaurants() {
    // Appel à l'API REST de votre Back-end
    fetch('/api/restaurants') 
        .then(response => {
            if (!response.ok) {
                throw new Error('Erreur réseau ou du serveur');
            }
            return response.json(); // Convertit la réponse en objet JavaScript
        })
        .then(restaurants => {
            const listElement = document.getElementById('restaurant-list');
            
            // Boucle sur les données reçues
            restaurants.forEach(resto => {
                const listItem = document.createElement('li');
                listItem.textContent = `${resto.nom} (${resto.typeRestau}) - ${resto.adresse}`;
                listElement.appendChild(listItem);
            });
        })
        .catch(error => {
            console.error('Erreur lors de la récupération des restaurants:', error);
            document.getElementById('restaurant-list').textContent = "Impossible de charger les données.";
        });
}