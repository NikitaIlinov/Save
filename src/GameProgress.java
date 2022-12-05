import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String url, GameProgress save){
        try (FileOutputStream fos = new FileOutputStream(url);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(save);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String fileName, String fileNameZip){
        try{ ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("C:/Netology/Games/savegames/zip.zip"));
            FileInputStream fis = new FileInputStream(fileName);
            ZipEntry entry = new ZipEntry(fileNameZip);
            zout.putNextEntry(entry);
            byte [] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFile(String url){
        File file = new File(url);
        if (file.delete()){
            System.out.println("Файл удален");
        }else System.out.println("Файл не обнаружен");
    }
}