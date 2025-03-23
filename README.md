# Overview

My main goal with this project was to learn the basics of java, like reading user input, creating functions, writing to a file, and retrieving program-wide variables. The program first asks the user to name their story, and then takes them through a choose-your-own adventure type setting, where their choices change the story, and ultimately, the fate of the world. Throughout their journey, the program saves the user's story to a file they can access after the story (something I hated about choose-your own-adventure stories as kid was having to flip back and forth between pages). Writing this was fun, and I learned a lot from it. Java really isn't all that different from C#, and I think this will be a fun story to play through. 
This project was a great introduction to Java, and I expect this practice will definitely aid me in future projects. 

[Java Text Story Link](https://youtu.be/ZqP6dNFd1Ms)

# Development Environment
- GitHub: Popular hosting and code repository site (what you're likely viewing the code on)
- Visual Studio Code: Source code editor with built-in terminal(s)


### Langauge & Libraries
- Java: Common object oriented programming language, used in both embedded and application environments.
- **Libraries:** *imported via " import java.io.library_name; "*
- BufferedReader
- IOException
- InputStreamReader
- StandardOpenOption
- Files
- Paths
- Collections

# Useful Websites

- [JavaSDK Downloader](https://www.oracle.com/java/technologies/downloads/?er=221886)
- [ChatGPT](https://chatgpt.com/) *Only used for finding basic syntax*

# Future Work
- __Improved Save Menu:__ The save menu just asks the user for a name, and immediately makes a .txt file. It could be greatly improved, giving users the option to write over a save, delete older save files, or even append to existing ones.
- __Advanced Story Saving:__ Any video game that gives users the option to save their progress typically lets them save at any point. This allows users to pause their game, or have multiple games running on different saves.  
- __Expanded Money System + Use:__ At different points, depending on the user's choices, they unlock access to their inventory, which shows how much money they have. The money, as of now only lets them bribe thieves to let them live. I'd like to implement some sort of purchase system so they can get gear, items, or even more story options.
