# Calculator Networking Samples

Welcome to the **Calculator Networking Samples** repository!

This repository showcases examples of calculator applications implemented using various networking technologies, including RMI and ServerSocket.

### Remote Method Invocation (RMI):
Remote Method Invocation (RMI) is a Java API that allows communication between different JVMs (Java Virtual Machines) over a network. It enables you to invoke methods on objects running on another JVM as if they were local objects from your computer.

### Key Concepts:
- **Remote Interface**:
  - A remote interface defines the methods that can be invoked remotely by clients. It lays out a template for the type of services our server will be providing. It extends the 'java.rmi.Remote' interface.

- **Remote Object**:
  - Remote objects are classes that implement the remote interface and provide the actual implementation of the methods to be invoked remotely. They serve as distributed services provided by the server and requested by clients.

- **Registry**:
  - A registry is a central repository where server objects register their services, and clients loop up for services they need. It acts as the headquarters that encapsulates the different services, such as departments in an organization.

- **Stub and Skeleton**:
  - The RMI generates stub and skeleton classes to handle communication between the client and server.
  - **Stub**:
    - The stub acts as a local representative or proxy for the remote object residing on another JVM. It receives method calls from the client and handles the marshalling of parameters, transmitting them over the network, and unmarshalling return values (if applicable). It essentially connects the client to the server.
  - **Skeleton**:
    - The skeleton resides on the server-side and serves as a mediator between the stub and the actual remote object. It receives method calls from the stub, unmarshals parameters, invokes corresponding methods on the remote object, and returns results (if applicable) to the stub.

### ServerSocket:
ServerSocket is a Java class that provides a mechanism for implementing server applications. It listens for incoming connections from clients and establishes a communication channel once a connection is accepted.

- **ServerSocket**:
  - ServerSocket binds to a specific port on the server and listens for incoming client connections.

- **Socket**:
  - Represents the endpoint of a connection between two machines.

- **Accepting Connections**:
  - ServerSocket's 'accept()' method blocks until a client connection request is received, then returns a Socket object representing the client connection.

- **Input and Output Streams**:
  - Once a connnection is established, Input and Output streams are used to send and receive data between the server and the client.

### Learning Resources:
- [Java RMI Tutorial](https://docs.oracle.com/javase/tutorial/rmi/index.html) - Official Java RMI tutorial by Oracle.
- [Java Networking Tutorial](https://docs.oracle.com/javase/tutorial/networking/index.html) - Official Java Networking tutorial by Oracle, covering topics including ServerSocket.

Please note that the provided explanation is concise, and further readings about these topics are encouraged for a deeper understanding.
