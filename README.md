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
            /* Semi-transparent background */
            padding: 10px 0;
            position: relative;
            z-index: 10;
            /* Ensure nav is on top of other content */
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
            /* Ensure section height */
        }

        .section.active {
            display: block;
            /* Show active section */
        }

        #products {
            background-image: url("hari/kid.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
            /* Ensure section height */
        }

        #about-us {
            background-image: url('path-to-your-about-us-background-image.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
            /* Ensure section height */
        }

        #contact {
            background-image: url('path-to-your-contact-background-image.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            padding: 50px;
            min-height: 300px;
            /* Ensure section height */
        }

        .gallery {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            padding: 20px;
            width: 80%;
            max-width: 1200px;
            margin: 20px auto;
            /* Center gallery and add margin */
        }

        .item {
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 8px;
            overflow: hidden;
            background-color: #fff;
            padding: 10px;
        }

        .item img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 8px;
        }

        .price {
            margin-top: 10px;
            font-size: 18px;
            color: #333;
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
    </nav>

    <div id="products" class="section">
        <div class="gallery" id="gallery">
            <!-- Items will be injected here by JavaScript -->
        </div>
    </div>

    <div id="about-us" class="section">
        <h2>About Us</h2>
        <p>>> Welcome to REDDY KIDS MALL.</p>
        <p>>> We offer a variety of toys for kids of all ages.</p>
        <p>>> Our mission is to provide
            quality toys at affordable prices.</p>
    </div>

    <div id="contact" class="section">
        <h2>Contact</h2>
        <p>For inquiries, please</p>
        <p>mail
            us at hariharanreddymatta1@gmail.com</p>
        <p>or</p>
        <p>call us at +91 8121403573.</p>
    </div>

    <script>
        // Array of image names
        const imageNames = [
            'toy 1.jpg', 'toy 2.jpg', 'toy 3.jpg', 'toy 4.jpg',
            'toy 5.jpg', 'toy 6.jpg', 'toy 7.jpg', 'toy 8.jpg'
        ];

        // Function to generate a random price between 500 and 5000
        function getRandomPrice() {
            return Math.floor(Math.random() * (5000 - 500 + 1)) + 500;
        }

        // Function to populate the gallery with items
        function populateGallery() {
            const gallery = document.getElementById('gallery');
            imageNames.forEach((imageName, index) => {
                const itemDiv = document.createElement('div');
                itemDiv.className = 'item';

                const img = document.createElement('img');
                img.src = imageName;
                img.alt = `Toy ${index + 1}`;

                const price = document.createElement('p');
                price.className = 'price';
                price.textContent = `₹${getRandomPrice().toLocaleString()}`;

                itemDiv.appendChild(img);
                itemDiv.appendChild(price);

                gallery.appendChild(itemDiv);
            });
        }

        // Function to show the selected section
        function showSection(sectionId) {
            // Hide all sections
            document.querySelectorAll('.section').forEach(section => {
                section.classList.remove('active');
            });

            // Show the selected section
            document.getElementById(sectionId).classList.add('active');
        }

        // Populate gallery on page load and show Products section by default
        window.onload = function () {
            populateGallery();
            showSection('products'); // Default to Products section
        };
    </script>
</body>

</html>
