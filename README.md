# OpenJobs Desktop Appilcation

![GitHub repo size](https://img.shields.io/github/repo-size/dileepabandara/openjobs_desktop?color=red&label=repository%20size)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/dileepabandara/openjobs_desktop?color=red)
![GitHub language count](https://img.shields.io/github/languages/count/dileepabandara/openjobs_desktop)
![GitHub top language](https://img.shields.io/github/languages/top/dileepabandara/openjobs_desktop)
![GitHub](https://img.shields.io/github/license/dileepabandara/openjobs_desktop?color=yellow)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/dileepabandara/openjobs_desktop?color=brightgreen&label=commits)

## ✨ About

The **OpenJobs Desktop Appilcation** helps to manage data congestion and find the best low-data traffic services. This concept is built on data structures. This alpha release does not include the complete requirements and interface. **This project has been developed as an open source for educational purposes.**

<br>

![Sample Screenshot](https://dileepabandara.github.io/public-images/projects/openjobs-desktop-preview.png)

### **Working Structure**

It uses 3 main user services and server services speed = 3 < 1 < 2

1. Server Services 1 = Receive Servers
   - Use Grapth Theory: Path Weighted Dijkstra's algorithm
   - Use Database Table: path_weighted
   - Use Vertex: 6
   - Path weight changes
   - Input source for find the minimum traffic between servers
   - Receive projects by minumum traffic server path
   - Admins can manage paths weight
   - Paths cannot change
   - Each vertex has 2 connections with 2 different vertex  
     <br>
2. Server Services 2 = Send Servers
   - Use Grapth Theory: Path Unweighted Dijkstra's algorithm
   - Use Database Table: path_unweighted
   - Use Vertex: 10
   - Vertext connection changes
   - Input source and destination for find the shortest lenghth
   - Send projects by shortest traffic server path
   - Admins can manage paths connection  
     <br>
3. Server Services 3 = Filter Projects, View Status, Transfer
   - Filter Projects
     - Use Sorting Algorithm: Quick Sort
     - Use Database Table: project
     - Filter by remaining project days
   - View Status
     - Use for view all summary and server health
     - Notify about upcoming projects
     - Use Database Table: upcoming_projects
   - Transfer
     - Use for view locations to transfer
     - This panel is under development

<br>

## 🎬 Release Status

Version - Alpha Release 1.0  
Initial release date - 19/10/2020

## 💡 Deployment

Deployment is not currently in use

## 💻 Built with

- Java
- Java Swing
- Data Structures
- NetBeans
- SQL Database

## 📌 Prerequisites

Before you get started, follow these requirements

- NetBeans
- WampServer or XAMPP is good for localhost
- phpMyAdmin database

## 🍃 How to Setup

- Download or clone the repository
- Move the project to the selected directory
- Clean and build project
- Use application to create the database

## 🚀 How to Run

- Clean and build the project
- Connect database and localhost
- Run the project
- Select the "Issue? Click here" option, then select the "Database Create" option to create the database

## 📸 Icons and Images

- Icons8 - https://icons8.com
- Freepik - https://www.freepik.com
- unDraw - https://undraw.co

## 🖼️ Project Gallery

Project screenshots and pictures - [Project Gallery](https://dileepabandara.github.io/project-gallery)

## ❤️ Thanks

Thanks to everyone who supported

## 👨‍💻 Developed By

Dileepa Bandara  
©dileepabandara.dev  
<https://dileepabandara.dev>

## 💬 Contact

If you want to contact me, leave a message via email or Twitter

- Email - <contact.dileepabandara@gmail.com>
- Twitter - [_dileepabandara](https://twitter.com/_dileepabandara)

## 📜 License

This project is licensed under the MIT License  
MIT ©dileepabandara.dev  
See the license file for more details [LICENSE.md](https://github.com/dileepabandara/openjobs_desktop/blob/main/LICENSE)
