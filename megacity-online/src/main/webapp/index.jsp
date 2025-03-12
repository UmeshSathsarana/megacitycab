<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MegaCityCabs</title>
    <style>
    
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1rem 5%;
            background-color: #000000;
            color: #FFD700;
        }

        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #FFD700;
            text-decoration: none;
            letter-spacing: 1px;
        }

        .nav-links {
            display: flex;
            gap: 2rem;
            list-style: none;
        }

        .nav-links a {
            color: #FFD700;
            text-decoration: none;
            font-size: 1.1rem;
            transition: color 0.3s ease;
            font-weight: 500;
        }

        .nav-links a:hover {
            color: #ffffff;
        }

        .hero-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 4rem 5%;
            background-color: #ffffff;
            gap: 40px;
            min-height: 80vh;
        }

        .hero-left {
            flex: 1;
            max-width: 50%;
        }

        .hero-right {
            flex: 1;
            max-width: 45%;
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
        }

        .hero-left h1 {
            font-size: 2.8rem;
            margin-bottom: 1.5rem;
            color: #000000;
            line-height: 1.2;
        }

        .hero-left p {
            color: #666;
            line-height: 1.7;
            font-size: 1.1rem;
            max-width: 80%;
        }

        .image-grid {
            position: relative;
            overflow: hidden;
            border-radius: 10px;
            transition: transform 0.3s ease;
            aspect-ratio: 1/1;
        }

        .image-grid img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            border-radius: 10px;
            transition: transform 0.3s ease;
        }

        .image-grid:hover {
            transform: scale(1.05);
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
        }

        @media (max-width: 768px) {
            .hero-container {
                flex-direction: column;
                padding: 2rem 5%;
            }
            .hero-left, .hero-right {
                max-width: 100%;
            }
            .hero-right {
                grid-template-columns: 1fr;
            }
            .hero-left h1 {
                font-size: 2rem;
            }
        }
        
        
        .nav-button {
            background-color: #FFD700;
            color: #000000 !important;
            padding: 0.8rem 1.6rem;
            border-radius: 15px;
            transition: all 0.3s ease;
            font-weight: 600;
            margin-left: 1rem;
        }

        .nav-button:hover {
            background-color: #FFC000;
            transform: translateY(-2px);
            box-shadow: 0 2px 8px rgba(255, 208, 0, 0.3);
            color: #000000;
        }
        
        .about-section {
            background-color: #000;
            color: #FFD700;
            padding: 4rem 5%;
            text-align: center;
        }

        .about-container {
            display: flex;
            align-items: center;
            justify-content: space-between;
            gap: 50px;
            flex-wrap: wrap;
        }

        .about-text {
            flex: 1;
            text-align: left;
        }

        .about-text h5 {
            font-size: 1.2rem;
            text-transform: uppercase;
            color: #ffffff;
        }

        .about-text h1 {
            font-size: 2.5rem;
            margin: 1rem 0;
            color: #FFD700;
        }

        .about-text p {
            font-size: 1.1rem;
            line-height: 1.7;
            color: #ccc;
        }

        .about-image {
            flex: 1;
            max-width: 50%;
        }

        .about-image img {
            width: 100%;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(255, 215, 0, 0.3);
        }

        /* Contact Us Section */
        .contact-header {
            background-color: #FFD700;
            color: #000;
            text-align: center;
            padding: 2rem 0;
        }

        .contact-header h1 {
            font-size: 2.5rem;
            margin-bottom: 0.5rem;
        }

        .contact-header p {
            font-size: 1.2rem;
        }

        .contact-container {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 50px;
            padding: 4rem 5%;
            flex-wrap: wrap;
            background-color: #000;
        }

        .contact-info {
            flex: 1;
            color: #FFD700;
        }

        .info-box {
            background: #222;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 10px;
            text-align: center;
        }

        .info-box h3 {
            margin-top: 10px;
            font-size: 1.5rem;
            color: #FFD700;
        }

        .info-box p {
            font-size: 1.1rem;
            color: #ccc;
        }

        .contact-form {
            flex: 1;
            background: #111;
            padding: 30px;
            border-radius: 10px;
            color: #FFD700;
            box-shadow: 0 5px 15px rgba(255, 215, 0, 0.2);
        }

        .contact-form h2 {
            font-size: 2rem;
            margin-bottom: 1rem;
            color: #FFD700;
        }

        .form-group {
            margin-bottom: 1rem;
        }

        .form-group label {
            display: block;
            font-size: 1.1rem;
            color: #FFD700;
        }

        .form-group input, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 2px solid #FFD700;
            border-radius: 5px;
            background: #222;
            color: #fff;
        }

        .submit-btn {
            background-color: #FFD700;
            color: #000;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-weight: bold;
            transition: all 0.3s ease;
        }

        .submit-btn:hover {
            background-color: #FFC000;
        }

        /* Footer */
        .footer-distributed {
            background: #000;
            color: #FFD700;
            padding: 2rem 5%;
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            text-align: left;
        }

        .footer-left, .footer-center, .footer-right {
            flex: 1;
            margin-bottom: 20px;
        }

        .footer-left h3 {
            font-size: 1.8rem;
            margin-bottom: 10px;
        }

        .footer-links a {
            display: inline-block;
            color: #FFD700;
            text-decoration: none;
            margin-right: 10px;
            transition: 0.3s;
        }

        .footer-links a:hover {
            color: #fff;
        }

        .footer-company-name {
            font-size: 1rem;
            margin-top: 10px;
        }

        .footer-center div {
            margin-bottom: 15px;
        }

        .footer-center i {
            color: #FFD700;
            margin-right: 10px;
        }

        .footer-company-about {
            font-size: 1rem;
            color: #ccc;
        }

        .footer-icons {
            margin-top: 10px;
        }

        .footer-icons a {
            display: inline-block;
            margin-right: 10px;
            font-size: 1.5rem;
            color: #FFD700;
            transition: 0.3s;
        }

        .footer-icons a:hover {
            color: #fff;
        }

        @media (max-width: 768px) {
            .about-container, .contact-container {
                flex-direction: column;
                text-align: center;
            }

            .about-image, .contact-info, .contact-form {
                max-width: 100%;
            }
        }
        .join-team {
    background-color: #FFD700; /* Yellow background */
    padding: 20px;
    text-align: center;
    border-radius: 10px;
    width: 320px;
    margin: 20px auto;
    position: relative;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
}

.join-team img {
    width: 100%;
    max-height: 150px;
    border-radius: 8px;
    object-fit: cover;
    margin-bottom: 10px;
}

.join-team p {
    font-size: 20px;
    color: #000; /* Black text */
    font-weight: bold;
    margin-bottom: 15px;
}

.join-btn {
    display: inline-block;
    background-color: #000; /* Black button */
    color: #FFD700; /* Yellow text */
    border: none;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    border-radius: 5px;
    text-decoration: none;
    transition: background 0.3s;
}

.join-btn:hover {
    background-color: #222; /* Darker black on hover */
}

.close-btn {
    position: absolute;
    top: 10px;
    right: 10px;
    background: #000; /* Black background */
    color: #FFD700; /* Yellow text */
    border: none;
    font-size: 20px;
    cursor: pointer;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    text-align: center;
    line-height: 30px;
    transition: background 0.3s;
}

/* Hides the close button by default since no JS is used */
.close-btn:hover {
    background: #222; /* Darker black */
}
        
        
        
    </style>
</head>
<body>
    <nav>
        <a href="#" class="logo">MegaCityCabs</a>
        <ul class="nav-links">
           <li><a href="jsp/register.jsp" class="nav-button">Login</a></li>
          
        </ul>
    </nav>

    <div class="hero-container">
        <div class="hero-left">
            <h1>MEGACITY CABS SERVICE</h1>
            <p>Mega City Cab Service is a reliable and efficient transportation solution, catering to the needs of individuals and businesses in Colombo City</p>
        </div>

        <div class="hero-right">
            <div class="image-grid">
                <img src="https://img.freepik.com/free-vector/taxi-logotype-design_1057-4891.jpg?t=st=1739715693~exp=1739719293~hmac=cd8e5871a6e9a7d9d733b844e88d7d6f2c4d32107a9af5807945637997cede64&w=740" alt="Luxury Cab">
            </div>
            <div class="image-grid">
                <img src="https://img.freepik.com/free-photo/woman-enjoying-her-financially-independence-while-buying-car_23-2149434385.jpg?t=st=1739715413~exp=1739719013~hmac=6f6466f32ed914b5b5dac39c510c66c6ec80ffae095caacbbfb6e71b42b0fc7a&w=1060" alt="City Ride">
            </div>
            <div class="image-grid">
                <img src="https://img.freepik.com/free-vector/taxi-app-concept_52683-35506.jpg?t=st=1739715583~exp=1739719183~hmac=d55da5a15eceb04d64b2a7b8f20e80b6cc5b927d30845c0bdecce92fca47792f&w=740" alt="24/7 Service">
            </div>
            <div class="image-grid">
                <img src="https://saitravelsahmedabad.com/images/car-rental-service-in-ahmedabad.webp" alt="Comfort Travel">
            </div>
        </div>
    </div>
    <section class="about-section">
    <div class="about-container">
      <!-- Text Column -->
      <div class="about-text">
        <h5>READ OUR STORY</h5>
        <h1>We've been Making The Delicious Foods Since 1999</h1>
        <p>
          Fusce hendrerit malesuada lacinia. Donec semper semper sem vitae malesuada.
          Proin scelerisque risus et ipsum semper molestie sed in nisi. Ut rhoncus congue lectus, 
          rhoncus venenatis leo malesuada id.
        </p>
        <p>
          Sed elementum vel felis sed scelerisque. In arcu diam, sollicitudin eu nibh ac, posuere 
          tristique magna. You can use this template for your cafe or restaurant website. Please 
          tell your friends about <b>templatemo</b>. Thank you.
        </p>
      </div>

      <!-- Image Column -->
      <div class="about-image">
        <img src="https://img.freepik.com/free-photo/businessman-posing-restaurant_1157-45815.jpg?t=st=1733839271~exp=1733842871~hmac=99859b4ee58372ce594cb07fec93ea1731efc00a2cf21fe04937d832a40bbd3f&w=996" alt="Chef with Food">
      </div>
    </div>
  </section>
  
  <div class="contact-header">
        <h1>Contact Us</h1>
        <p>Get in touch with us for any questions or concerns</p>
    </div>

    <div class="contact-container">
        <div class="contact-info">
            <div class="info-box">
                <h3>Our Location</h3>
                <p>123 Fitness Street</p>
                <p>New York, NY 10001</p>
            </div>
            <div class="info-box">
                                <h3>Phone Number</h3>
                <p>+1 (555) 123-4567</p>
                <p>Mon-Fri: 6am - 10pm</p>
            </div>
            <div class="info-box">
                <h3>Email Address</h3>
                <p>info@fitzone.com</p>
                <p>support@fitzone.com</p>
            </div>
        </div>

        <div class="contact-form">
            <h2>Send us a Message</h2>
            <form action="contact" method="POST">
                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="subject">Subject</label>
                    <input type="text" id="subject" name="subject" required>
                </div>
                <div class="form-group">
                    <label for="message">Message</label>
                    <textarea id="message" name="message" required></textarea>
                </div>
                <button type="submit" class="submit-btn">Send Message</button>
            </form>
        </div>
        <div class="join-team">
    <button class="close-btn">&times;</button>
    <img src="https://cdn-icons-png.freepik.com/256/11376/11376485.png?ga=GA1.1.1329889143.1739290285&semt=ais_hybrid" alt="Driver Recruitment">
    <p>Join our team <br> in hire drivers</p>
    <a href="jsp/driver/dregister.jsp" class="join-btn">Join now</a>
</div>

  <!--Footer-->
 <br>
 <footer class="footer-distributed">
 
  <div class="footer-left">

  <h3>Cineplex<span>Cinema</span></h3>

  <p class="footer-links">
  <a href="index.html">Home</a>
·
  <a href="about.html">About</a>
·
  <a href="contact.html">Contact</a>
  </p>

  <p class="footer-company-name">CineplexCinema &copy; 2024</p>
  </div>

  <div class="footer-center">

  <div>
  <i class="fa fa-map-marker"></i>
  <p><span>21 Revolution Street</span> Kandy, SriLanka</p>
  </div>

  <div>
  <i class="fa fa-phone"></i>
  <p>+94 0781210939</p>
  </div>

  <div>
  <i class="fa fa-envelope"></i>
  <p><a href="mailto:contact@fantasycinema.com">contact@cineplexcinema.com</a></p>
  </div>

  </div>

  <div class="footer-right">

  <p class="footer-company-about">
  <span>About the company</span>
  And so, the Cineplex Cinema online booking website became a legend in Movietown, a testament to the magic of cinema that could be experienced even before stepping into the theatre.
  </p>

  <div class="footer-icons">

  <a href="https://facebook.com"><i class="fa-brands fa-facebook"></i></a>
  <a href="https://twitter.com"><i class="fa-brands fa-twitter"></i></i></a>
  <a href="https://linkedin.com"><i class="fa-brands fa-linkedin"></i></i></a>

  </div>

  </div>

  </footer>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
