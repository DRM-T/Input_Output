import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Utils {

    /** Đọc nội dung file có đường dẫn path. */
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /** Ghi nội dung content vào file có đường dẫn path (xóa nội dung cũ). */
    public static void writeContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Ghi nội dung content vào file có đường dẫn path (không xóa nội dung cũ). */
    public static void appendContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Tìm tên file có trong folder cho trước. */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("Duong dan khong phai thu muc.");
            return null;
        }

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }

        System.out.println("Khong tim thay tep co ten: " + fileName + " trong thu muc " + folderPath);
        return null;
    }

    public static void main(String[] args) {

        String filePath = "E:\\testWeek9.txt";
        String content = readContentFromFile(filePath);
        System.out.println("File content: \n" + content);

        String writeFilePath = "E:\\\\testWeek9.txt";
        String textToWrite = "This is a test text.\nNew line added.";
        writeContentToFile(writeFilePath, textToWrite);

        String appendFilePath = "E:\\\\testWeek9.txt";
        String textToAppend = "\nThis is appended text.";
        appendContentToFile(appendFilePath, textToAppend);

        String folderPath = "E:\\";
        String fileNameToFind = "testWeek9.txt";
        File foundFile = findFileByName(folderPath, fileNameToFind);
        if (foundFile != null) {
            System.out.println("Tệp " + fileNameToFind + " đã được tìm thấy: " + foundFile.getAbsolutePath());
        }
    }
}
