  /**
   * Deletes the contents of {@code dir}. Throws an IOException if any file
   * could not be deleted, or if {@code dir} is not a readable directory.
   */
  public static void deleteContents(File dir) throws IOException {
    File[] f = dir.listFiles();
    if (f == null) {
      throw new IOException("not a readable directory: " + dir);
    }
    for (File f1 : f) {
      if (f1.isDirectory()) {
        deleteContents(file);
      }
      if (!f1.delete()) {
        throw new IOException("failed to delete file: " + f1);
      }
    }
  }