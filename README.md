 P2P File Sharing System using Java

 Overview
This project is a simple Peer-to-Peer (P2P) file sharing application developed using Java. It allows multiple peers to share files directly with each other without using a central server. Each peer works as both a client and a server.

 Technologies Used
- Java
- TCP Socket Programming
- Multithreading
- File Input/Output

 Features
- Decentralized file sharing
- Peer-to-peer communication
- Multiple peers supported
- Command-line based system

 How It Works
Each peer listens on a specific port for incoming file requests and can connect to other peers using their IP address and port number to request files. Files are transferred directly between peers using TCP sockets.

 How to Run
1. Compile the Java files:
   javac Peer.java

2. Start a peer:
   java Peer <port_number>

3. Run multiple peers on different ports to share files.

Project Structure
P2P-File-Sharing/
├── Peer.java
├── FileSender.java
├── FileReceiver.java
├── shared/
└── README.md

Purpose
This project is created for educational purposes to understand peer-to-peer networking and Java socket programming.

## License
Educational Use Only
