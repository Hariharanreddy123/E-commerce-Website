<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>REDDY KIDS MALL</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }

        header {
            background-color: #ffcccc;
            padding: 20px;
            text-align: center;
            position: relative;
            z-index: 10;
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
            color: #ff6666;
        }

        nav {
            display: flex;
            justify-content: center;
            background-color: rgba(255, 102, 102, 0.9);
            padding: 10px 0;
            position: relative;
            z-index: 10;
        }

        nav a {
            margin: 0 15px;
            padding: 10px 20px;
            color: white;
            text-decoration: none;
            font-size: 1.2em;
        }

        nav a:hover {
            background-color: #ff3333;
            border-radius: 5px;
        }

        .section {
            display: none;
            padding: 20px;
            background-color: #fff;
            min-height: 300px;
        }

        .section.active {
            display: block;
        }

        #products {
            background-image: url('https://via.placeholder.com/1200x600.png?text=Products');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
        }

        #about-us {
            background-image: url('https://via.placeholder.com/1200x600.png?text=About+Us');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
        }

        #contact {
            background-image: url('https://via.placeholder.com/1200x600.png?text=Contact');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
        }

        .gallery {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            padding: 20px;
            width: 80%;
            max-width: 1200px;
            margin: 20px auto;
        }

        .item {
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            background-color: #fff;
            padding: 10px;
            position: relative;
        }

        .item img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 8px;
            transition: transform 0.3s ease;
        }

        .item img:hover {
            transform: scale(1.2);
        }

        .price {
            margin-top: 10px;
            font-size: 18px;
            color: #333;
        }

        .filter,
        .sort {
            margin: 20px;
            text-align: center;
        }

        .filter input,
        .sort select {
            padding: 10px;
            font-size: 1em;
            margin: 10px;
        }

        .add-to-cart {
            background-color: #ff6666;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: transform 0.2s, background-color 0.3s;
        }

        .add-to-cart:hover {
            background-color: #ff3333;
        }

        .add-to-cart:active {
            transform: scale(0.95);
        }

        .review-section {
            margin: 20px;
        }

        .review-section h2 {
            margin-bottom: 10px;
        }

        .review {
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fafafa;
        }

        .order-history {
            display: none;
            padding: 20px;
            background-color: #fff;
        }

        .order-history.active {
            display: block;
        }

        .video-section {
            margin: 20px;
            text-align: center;
        }

        .video-section img {
            cursor: pointer;
            width: 100%;
            max-width: 600px;
            border-radius: 8px;
        }

        .video-section iframe {
            width: 100%;
            max-width: 600px;
            height: 315px;
            border: none;
            border-radius: 8px;
        }
    </style>
</head>

<body>
    <header>
        <h1>REDDY KIDS MALL</h1>
    </header>
    <nav>
        <a href="#products" onclick="showSection('products')">Products</a>
        <a href="#about-us" onclick="showSection('about-us')">About Us</a>
        <a href="#contact" onclick="showSection('contact')">Contact</a>
        <a href="#order-history" onclick="showSection('order-history')">Order History</a>
    </nav>

    <div id="products" class="section">
        <div class="filter">
            <input type="text" id="search" placeholder="Search for products..." oninput="filterProducts()">
        </div>
        <div class="sort">
            <select id="sort" onchange="sortProducts()">
                <option value="default">Sort By</option>
                <option value="price-asc">Price: Low to High</option>
                <option value="price-desc">Price: High to Low</option>
            </select>
        </div>
        <div class="gallery" id="gallery">
            <!-- Items will be injected here by JavaScript -->
        </div>
    </div>

    <div id="about-us" class="section">
        <h2>About Us</h2>
        <p>>> Welcome to REDDY KIDS MALL.</p>
        <p>>> We offer a variety of toys for kids of all ages.</p>
        <p>>> Our mission is to provide quality toys at affordable prices.</p>
    </div>

    <div id="contact" class="section">
        <h2>Contact</h2>
        <p>For inquiries, please mail us at hariharanreddymatta1@gmail.com</p>
        <p>or call us at +91 8121403573.</p>
    </div>

    <div id="order-history" class="section order-history">
        <h2>Order History</h2>
        <p>Your previous orders will be listed here.</p>
    </div>

    <div class="video-section">
        <h2>Product Demo Video</h2>
        <img src="Project 1_E-commerce Website/v1.html" onclick="showVideo()">
        <div id="video-player" style="display:none;">
            <iframe src="" id="video-frame" frameborder="0"></iframe>
        </div>
    </div>

    <script>
        // Array of product data
        const products = [
            { imageName: 'Project 1_E-commerce Website/TOY 1.jpg', price: getRandomPrice(), name: 'Toy 1' },
            { imageName: 'Project 1_E-commerce Website/TOY 2.jpg', price: getRandomPrice(), name: 'Toy 2' },
            { imageName: 'Project 1_E-commerce Website/TOY 3.jpg', price: getRandomPrice(), name: 'Toy 3' },
            { imageName: 'Project 1_E-commerce Website/TOY 4.jpg', price: getRandomPrice(), name: 'Toy 4' },
            { imageName: 'Project 1_E-commerce Website/TOY 5.jpg', price: getRandomPrice(), name: 'Toy 5' },
            { imageName: 'Project 1_E-commerce Website/TOY 6.jpg', price: getRandomPrice(), name: 'Toy 6' },
            { imageName: 'Project 1_E-commerce Website/TOY 7.jpg', price: getRandomPrice(), name: 'Toy 7' },
            { imageName: 'Project 1_E-commerce Website/TOY 9.jpg', price: getRandomPrice(), name: 'Toy 8' }
        ];

        function getRandomPrice() {
            return Math.floor(Math.random() * (5000 - 500 + 1)) + 500;
        }

        function populateGallery() {
            const gallery = document.getElementById('gallery');
            gallery.innerHTML = ''; // Clear existing items
            products.forEach(product => {
                const itemDiv = document.createElement('div');
                itemDiv.className = 'item';

                const img = document.createElement('img');
                img.src = product.imageName;
                img.alt = product.name;

                const price = document.createElement('p');
                price.className = 'price';
                price.textContent = `₹${product.price.toLocaleString()}`;

                const addButton = document.createElement('button');
                addButton.className = 'add-to-cart';
                addButton.textContent = 'Add to Cart';
                addButton.onclick = () => addToCart(product);

                itemDiv.appendChild(img);
                itemDiv.appendChild(price);
                itemDiv.appendChild(addButton);

                gallery.appendChild(itemDiv);
            });
        }

        function filterProducts() {
            const search = document.getElementById('search').value.toLowerCase();
            const filteredProducts = products.filter(product => product.name.toLowerCase().includes(search));
            displayProducts(filteredProducts);
        }

        function sortProducts() {
            const sortValue = document.getElementById('sort').value;
            let sortedProducts = [...products];
            if (sortValue === 'price-asc') {
                sortedProducts.sort((a, b) => a.price - b.price);
            } else if (sortValue === 'price-desc') {
                sortedProducts.sort((a, b) => b.price - a.price);
            }
            displayProducts(sortedProducts);
        }

        function displayProducts(productsToDisplay) {
            const gallery = document.getElementById('gallery');
            gallery.innerHTML = ''; // Clear existing items
            productsToDisplay.forEach(product => {
                const itemDiv = document.createElement('div');
                itemDiv.className = 'item';

                const img = document.createElement('img');
                img.src = product.imageName;
                img.alt = product.name;

                const price = document.createElement('p');
                price.className = 'price';
                price.textContent = `₹${product.price.toLocaleString()}`;

                const addButton = document.createElement('button');
                addButton.className = 'add-to-cart';
                addButton.textContent = 'Add to Cart';
                addButton.onclick = () => addToCart(product);

                itemDiv.appendChild(img);
                itemDiv.appendChild(price);
                itemDiv.appendChild(addButton);

                gallery.appendChild(itemDiv);
            });
        }

        const cart = JSON.parse(localStorage.getItem('cart')) || [];

        function addToCart(product) {
            cart.push(product);
            localStorage.setItem('cart', JSON.stringify(cart));
            animateAddToCart();
        }

        function animateAddToCart() {
            const buttons = document.querySelectorAll('.add-to-cart');
            buttons.forEach(button => {
                button.classList.add('pulse');
                setTimeout(() => button.classList.remove('pulse'), 1000);
            });
        }

        function showSection(sectionId) {
            document.querySelectorAll('.section').forEach(section => {
                section.classList.remove('active');
            });
            document.getElementById(sectionId).classList.add('active');
        }

        function showVideo() {
            document.getElementById('video-player').style.display = 'block';
            document.getElementById('video-frame').src = 'https://www.youtube.com/embed/dQw4w9WgXcQ'; // Replace with actual video URL
        }

        window.onload = function () {
            populateGallery();
            showSection('products'); // Default to Products section
        };
    </script>
</body>

</html>
