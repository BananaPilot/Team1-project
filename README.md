# Logistics and Managment application 

As the managment application user you can benefit of a system that integrates customer management, order processing, product inventory, supplier management, and warehouse operations so that you can efficiently track, manage, and fulfill orders, optimize stock levels, and gain valuable insights to improve your business.

## This system allows you to:

- Manage customers: Create, view, and update customer profiles
- Process orders: Create new orders, manage and track orders
- Manage products: Add, edit, and delete product information, including descriptions, prices, stock levels, and supplier details
- Manage suppliers: Create, view, and update supplier information 
- Manage warehouse operations: Track product location within the warehouse, optimize storage layouts, and manage stock movement

## Benefits:
- Enhanced data visibility: Gain real-time insights into customer orders, inventory levels, and supplier information
- Optimized stock management: Minimize stockouts and overstocking by effectively managing inventory levels
- Improved decision-making: Data-driven insights enable better decision-making regarding pricing, promotions, and supplier relationships
- Enhanced customer satisfaction: Efficient order processing and communication lead to improved customer satisfaction


# Application features
## Customer
As a user of the application you are able to create and manage customer information necessary for optimal customer handling.

### Key Features:
-- Customer Account Management: 
- Create new customer accounts with essential details (name, address, email, phone number).
- List all customers com.team1.app.classes.in the system for easy overview.
- Search for specific customers using various criteria: ID, email, or name and surname.
- View detailed information about a selected customer.
- Update a customer's details (name, address, email, phone number) as needed.
- Delete customer accounts when necessary.
-- Order Management:
- For a selected customer, seamlessly access and manage their complete order history.
- Navigate to a dedicated order management module to perform further order-related actions.

### Benefits:
- Streamlined Customer Administration: Efficiently create, view, update, and delete customer accounts thus saving time and effort.
- Flexible Customer Search: Easily locate specific customers using multiple search options, enhancing record-keeping accuracy.
- Integrated Order Handling: Directly manage customer orders from within their profiles, promoting a cohesive workflow.
- User-Friendly Interface: Navigate through clear prompts and menus, fostering a positive user experience for administrators.



## Supplier
As the application user you are able to create and manage supplier information, including their company name, product category they supply, and VAT number; easily access and update supplier details, view a list of all suppliers and place orders directly from a specific supplier.

### Key Features:
-- Supplier Management: Enables creating, viewing, updating, and deleting supplier profiles. Each supplier has attributes like company name, supplied product type and VAT number.

-- Supplier Interaction: Provides a user interface for managing suppliers, including functionalities like:
- Creating new suppliers
- Listing existing suppliers
- Searching for specific suppliers
- Updating supplier information
- Deleting suppliers
- Placing orders directly from a chosen supplier
- Order placing: Base functionality for placing orders, allowing potential future implementations for order management related to specific suppliers.

### Benefits:
- Improved Supplier Data Management: Facilitates efficient creation, storage, and retrieval of supplier information.
- Simplified Supplier Interaction: Provides a user-friendly interface for managing suppliers and their details.
- Centralized Supplier Information: Offers a single point of reference for all supplier-related data.
- Streamlined Order Placement: Enables placing orders directly from chosen suppliers, potentially improving efficiency.



## Product
As an application user, you can manage product related information com.team1.app.classes.in order to track product levels, generate reports, and make informed decisions about ordering and stocking.

### Key Features:
-- Product Class:
- Creates new products with essential details: Unique ID (UUID), name, brand, description, price, current quantity, stock date, supplier, product type and storage position
- Retrieves and updates product information
- Calculates current quantity based on product movements
-- ProductTracking Class: tracks product movements, including:
- Incoming quantity
- Outgoing quantity
- Disposed-of quantity
- Stock date
- Automatically calculates the current quantity after each movement entry
-- Inventory Management:
- Creates and manages a list of products with detailed information
- Records product movements using the ProductTracking class
- Automatically updates current quantities based on tracked movements
- Provides methods to retrieve product information, including current quantity and movement history

### Benefits:
- Improved Inventory Management: Centralized data, accurate tracking, and automated calculations.
- Enhanced Decision-Making: Insights into trends and proactive issue identification.
- Increased Efficiency: Automated calculations and structured data management.
- Scalability & Flexibility: Foundation for future functionalities.



## Order
As an application user you are able to manage orders com.team1.app.classes.in a system that offers functionalities like creating, listing, searching, updating, and deleting orders.

### Key Features:
- Order Creation: create new orders by adding existing products from the database or creating new ones on-the-fly.
- Order Management: list existing orders, search for them by ID or date, update individual order items (quantity or product), and delete unwanted orders.
- User Interaction: Employ a user-friendly menu-driven interface for interacting with the system through prompts and user input.
- Order Persistence: The current version of the application focuses on com.team1.app.classes.in-memory storage; nevertheless integration with a database (e.g., MySQL, SQLite) can be implemented for persistence.

### Benefits:
- Improved Order Handling: Streamlines order creation, management, and tracking within your application.
- Simplified User Interaction: Offers a user-friendly interface for interacting with orders, enhancing overall usability.
- Flexibility: Can be adapted to various scenarios requiring order management by integrating it with your specific data structures and business logic.



## Storage (Position/Zone)
As an application user you can create zones within the warehouse to organize products efficiently, define the size and number of racks within each zone for optimized storage, easily identify the location (lot) of a specific product com.team1.app.classes.in the warehouse and track the availability (full or empty) of individual positions within the zone.

### Key Features:
- Zone Creation: Allows defining named zones (sectors) within the warehouse for organizational purposes.
- Rack Configuration: Enables specifying the number of racks, their width, and height within a zone, impacting the total number of positions.
- Position Management: Models individual storage locations within a zone. Each position has a unique lot identifier, tracks its availability, and can hold a single product with a specific quantity.
- Position Search: offers search functionalities within zones based on various criteria.

### Benefits:
- Improved Warehouse Organization: Enables creating a structured layout within the warehouse by defining zones and racks for efficient storage and retrieval of products.
- Enhanced Tracking and Management: Provides a system for tracking the location of products (lot) and their availability within the warehouse, facilitating inventory management tasks.
- Scalability: The code can be easily adapted to accommodate warehouses of varying sizes and storage needs by modifying the number and configuration of zones and racks.



## Database
As an application user you will use an com.team1.app.classes.in-Memory Data Storage: rather than using a traditional database system like MySQL or SQLite, the applications database employs Java's ArrayLists to store data directly com.team1.app.classes.in memory during program execution.

### Data Organization:
- Products: Stored com.team1.app.classes.in an ArrayList of Product objects.
- Suppliers: Stored com.team1.app.classes.in an ArrayList of Supplier objects.
- Product Types: Stored com.team1.app.classes.in an ArrayList of ProductType objects.
- Zones: Stored com.team1.app.classes.in an ArrayList of Zone objects.
- Customers: Stored com.team1.app.classes.in an ArrayList of Customer objects.

### Key Features:
- Unified Data Access: Provides a single point of access to various data entities within your application, including products, suppliers, product types, zones, and customers.
- Singleton Pattern: Ensures only one instance of the DB class exists, promoting code efficiency and simplified access.
- Lazy Initialization: Optimizes memory usage by creating data lists (products, suppliers, etc.) only when needed, improving performance com.team1.app.classes.in scenarios where not all data is required immediately.
- Type Safety: Utilizes Java's type system to enforce data integrity and prevent runtime errors by ensuring specific data types are used with corresponding methods.

### Benefits:
- Improved Code Organization: Concentrates data management com.team1.app.classes.in a dedicated class, enhancing code maintainability and readability.
- Simplified Data Access: Enables easy retrieval of different data types using dedicated getter methods.
- Memory Efficiency: Delays list creation until necessary, reducing memory overhead com.team1.app.classes.in situations where complete data isn't always essential.
- Reduced Errors: Type safety helps to catch potential type-related errors early com.team1.app.classes.in the development process, leading to more robust and reliable code.
## 🔗 Links
[![github](https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/GitHub_logo_2013.svg/120px-GitHub_logo_2013.svg.png)](https://github.com/BananaPilot/Team1-project) Managment Application code on GitHub
