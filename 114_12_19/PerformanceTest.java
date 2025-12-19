import java.io.*;

public class PerformanceTest {
    public static void main(String[] args) throws IOException {
        // 建立測試檔案（約 10MB）
        createTestFile("testfile.bin", 10 * 1024 * 1024);
        
        // 測試一：無緩衝，逐位元組讀取
        long start1 = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("testfile.bin")) {
            while (fis.read() != -1) { }
        }
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("無緩衝逐位元組: " + time1 + " ms");
        
        // 測試二：無緩衝，使用陣列讀取
        long start2 = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream("testfile.bin")) {
            byte[] buffer = new byte[8192];
            while (fis.read(buffer) != -1) { }
        }
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("無緩衝陣列讀取: " + time2 + " ms");
        
        // 測試三：使用 BufferedInputStream
        long start3 = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("testfile.bin"))) {
            while (bis.read() != -1) { }
        }
        long time3 = System.currentTimeMillis() - start3;
        System.out.println("BufferedInputStream: " + time3 + " ms");
        
        // 測試四：BufferedInputStream + 陣列
        long start4 = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("testfile.bin"))) {
            byte[] buffer = new byte[8192];
            while (bis.read(buffer) != -1) { }
        }
        long time4 = System.currentTimeMillis() - start4;
        System.out.println("BufferedInputStream + 陣列: " + time4 + " ms");
        
        new File("testfile.bin").delete();
    }
    
    private static void createTestFile(String filename, int size) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] data = new byte[8192];
            int remaining = size;
            while (remaining > 0) {
                int toWrite = Math.min(data.length, remaining);
                fos.write(data, 0, toWrite);
                remaining -= toWrite;
            }
        }
    }
}
