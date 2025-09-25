# Java Selenium Amazon Website Automation

## Overview

This project is a **Java Selenium automation framework** for testing Amazon UK website.  
It allows you to search for products, retrieve product information, and open product pages.

The framework uses:
- **Java 21**
- **Selenium 4.25**
- **TestNG** for test management
- **Maven** for dependency management
- **ChromeDriver** (supports Mac M3)

---



## Project Structure

JavaSelniumAmazonWebsiteAutomation/
├── src/
│ ├── main/java/ # Main Java code (pages, utilities)
│ └── test/java/ # Test classes
├── pom.xml # Maven configuration
└── README.md # Project documentation

---



## Setup

1. **Clone the repository:**

```bash
git clone https://github.com/sonalipatilqaa-art/JavaSelniumAmazonWebsiteAutomation.git
cd JavaSelniumAmazonWebsiteAutomation
Install dependencies via Maven:
mvn clean install
Run tests:
mvn test
Notes
ChromeDriver must match your installed Chrome version.
Popups (cookies, location) are handled automatically.
Ensure network access to Amazon UK.
