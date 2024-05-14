package org.example.Model;

public class QuizModel {
    private String[] questions = {"What is a polyhedron?",
            "How many faces does a cube have?",
            "What is a regular polyhedron?",
            "How many edges does a tetrahedron have?",
            "What polyhedron has 12 faces, all of which are pentagons?",
            "How many vertices does an octahedron have?",
            "What is the dual polyhedron of a cube?",
            "How many faces does a dodecahedron have?",
            "What is the shape of the faces of a regular tetrahedron?",
            "How many edges does a dodecahedron have?"};
    private String[][] options = {
            {"A 3D shape with flat faces", "A 2D shape", "A circle", "A type of polygon", "None of the above"},
            {"4", "6", "8", "12", "20"},
            {"A polyhedron with all faces of equal area", "A polyhedron with all edges of the same length", "A polyhedron with identical faces meeting at each vertex", "A polyhedron that can roll", "None of the above"},
            {"4", "6", "8", "12", "14"},
            {"Tetrahedron", "Cube", "Octahedron", "Dodecahedron", "Icosahedron"},
            {"4", "6", "8", "12", "20"},
            {"Tetrahedron", "Octahedron", "Icosahedron", "Dodecahedron", "Sphere"},
            {"4", "6", "8", "12", "20"},
            {"Triangle", "Square", "Pentagon", "Hexagon", "Circle"},
            {"12", "18", "30", "60", "90"}
    };
    private char[] answers = {'A', 'B', 'C', 'B', 'D', 'C', 'B', 'D', 'A', 'C'};

    public String getQuestion(int index) {
        return questions[index];
    }

    public String[] getOptions(int index) {
        return options[index];
    }

    public char getAnswer(int index) {
        return answers[index];
    }

    public int getTotalQuestions() {
        return questions.length;
    }
}
