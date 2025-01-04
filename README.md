# 3D Renderer

3D Renderer is a Java-based application that allows users to render 3D shapes such as tetrahedrons, octahedrons, and cubes. The program features lighting, shading, and rotation to provide a realistic rendering experience.

## Getting Started

These instructions will guide you through setting up and running the 3D Renderer on your local machine.

### Prerequisites

Ensure you have the following installed on your system:

- [Java Development Kit (JDK) 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)

### Installing

You can run the 3D Renderer using one of the following options:

#### Option 1: Run the Precompiled Version (Tetrahedron)
1. Clone the repository:
   ```bash
   git clone https://github.com/Junichi-K/3D-Renderer.git
   ```
2. Navigate to the `dist` directory:
   ```bash
   cd 3D-Renderer/dist
   ```
3. Run the precompiled `.jar` file:
   ```bash
   java -jar 3dRendererAnt.jar
   ```
   Alternatively, double-click the `3dRendererAnt.jar` file to launch the application and view the tetrahedron.

#### Option 2: Customize and Run the Application
1. Clone the repository as above.
2. Navigate to the `src` directory:
   ```bash
   cd 3D-Renderer/src
   ```
3. Edit the `DemoViewer` class to specify the desired shape:
   - Locate the following line in `DemoViewer.java`:
     ```java
     private Tetrahedron shape;
     ```
   - Replace `Tetrahedron` with `Octahedron` or `Cube` to render the corresponding shape.
4. Compile the `DemoViewer` class:
   ```bash
   javac demoviewer/DemoViewer.java
   ```
5. Navigate to the `dist` directory and run the `.jar` file as described in Option 1.

### Note on IDE Usage
If you prefer, you can also import the project into an IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/ide/):
- Open the project as a new Java project.
- Edit and compile the `DemoViewer` class directly from the IDE.

## Directory Structure

The project has the following structure:

```
3D-Renderer/
├── build/          # Compiled bytecode and intermediary build files
├── dist/           # Precompiled JAR file
│   └── 3dRendererAnt.jar
├── src/            # Source code files
│   ├── demoviewer/DemoViewer.java  # Main class for rendering shapes
│   └── shapes/                     # Classes for various 3D shapes
├── build.xml       # Build configuration file
├── manifest.mf     # Manifest file for the JAR
└── README.md       # Project documentation
```

## Built With

- [Java](https://www.oracle.com/java/) - The programming language used for the application's logic and implementation.
- [Swing](https://docs.oracle.com/javase/tutorial/uiswing/) - A Java GUI toolkit used to create the rendering interface.

## Features

- **Lighting**: Realistic light effects to enhance the appearance of 3D shapes.
- **Shading**: Smooth shading for better depth perception.
- **Rotation**: Interactive rotation for viewing shapes from different angles.

## Contributing

Feel free to fork the repository and submit pull requests. Contributions are welcome to improve features or add new ones.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- Inspired by 3D rendering techniques and Java's capabilities.
