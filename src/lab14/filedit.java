package lab14;

import java.io.*;

//  filedit  –  file read / write helper class

public class filedit {

    public void printfile(String text) throws IOException {
        String path = SimpleTextEditor.currentFilePath;
        if (path == null || path.isEmpty()) {
            throw new IOException("No file path specified.");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
        }
    }

    public String readfile(String fname) throws IOException {
        if (fname == null || fname.isEmpty()) {
            throw new IOException("No file path specified.");
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fname))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        // Remove trailing newline if present
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
