import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String baseDirPath = "D:\\JAVA_Projects\\Games\\";

        String[] directoriesInGames = {"src", "res", "savegames", "temp" };
        String[] directoriesInSrc = {"main", "test" };
        String[] filesInMain = {"Main.java", "Utils.java" };
        String[] directoriesInRes = {"drawables", "vectors", "icons" };
        String[] filesInTemp = {"temp.txt" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < directoriesInGames.length; i++) {
            String fullPath = baseDirPath + directoriesInGames[i];
            File dir = new File(fullPath);
            String message = "";
            if (dir.mkdir()) {
                message = "Каталог \"" + fullPath + "\" создан";
            } else {
                message = "Ошибка создания каталога \"" + fullPath + "\"";
            }
            System.out.println(message);
            sb.append(message + "\n");
        }

        File src = new File(baseDirPath + directoriesInGames[0]);
        if (src.isDirectory()) {
            for (int i = 0; i < directoriesInSrc.length; i++) {
                String fullPath = baseDirPath + directoriesInGames[0] + "\\" + directoriesInSrc[i];
                File dir = new File(fullPath);
                String message = "";
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка создания каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        File res = new File(baseDirPath + directoriesInGames[1]);
        if (res.isDirectory()) {
            for (int i = 0; i < directoriesInRes.length; i++) {
                String fullPath = baseDirPath + directoriesInGames[1] + "\\" + directoriesInRes[i];
                File dir = new File(fullPath);
                String message = "";
                if (dir.mkdir()) {
                    message = "Каталог \"" + fullPath + "\" создан";
                } else {
                    message = "Ошибка создания каталога \"" + fullPath + "\"";
                }
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String fullDirectoryMainPath = baseDirPath + directoriesInGames[0] + "\\" + directoriesInSrc[0] + "\\";
        for (int i = 0; i < filesInMain.length; i++) {
            String message = "";
            String fullMainFileName = fullDirectoryMainPath + filesInMain[i];
            File myFile = new File(fullMainFileName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullMainFileName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String fullDirectoryTempPath = baseDirPath + directoriesInGames[3] + "\\";
        for (int i = 0; i < filesInTemp.length; i++) {
            String message = "";
            String fullFileTempName = fullDirectoryTempPath + filesInTemp[i];
            File myFile = new File(fullFileTempName);
            try {
                if (myFile.createNewFile())
                    message = "Файл \"" + fullFileTempName + "\" создан";
            } catch (IOException ex) {
                message = ex.getMessage();
            } finally {
                System.out.println(message);
                sb.append(message + "\n");
            }
        }

        String tempFileForLog = baseDirPath + directoriesInGames[3] + "\\" + filesInTemp[0];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFileForLog))) {
            String log = sb.toString();
            String text = log;
            bw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage(
            ));
        }
    }
}
