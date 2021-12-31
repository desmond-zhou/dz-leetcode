class File {
    String name;
    boolean isDirectory;
    LinkedList<String> content;
    TreeMap<String, File> children;
    File parent;
    public File(String name, boolean isDirectory, File parent) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.content = new LinkedList<>();
        this.children = new TreeMap<String, File>();
        this.parent = parent;
    }
    
    public File descend(String s) {
        return children.get(s);
    }
}

class FileSystem {
    File root;
    
    public FileSystem() {
        root = new File("", true, null);
    }
    
    public List<String> ls(String path) {
        System.out.println("ls " + path);
        File dir = navigate(path, false);
        if (dir.isDirectory) {
            List<String> result = new ArrayList<>();
            for (String name : dir.children.keySet()) {
                result.add(name);
            }
            return result;
        } else {
            return List.of(dir.name);
        }
    }
    
    private File navigate(String path, boolean create) {
        String[] token = stripPathRootAndTokenize(path);
        File cur = root;
        for (String t : token) {
            if (t.isEmpty()) continue;
            if (!cur.children.containsKey(t) && create) cur.children.put(t, new File(t, true, cur));
            cur = cur.descend(t);
        }
        return cur;
    }
    
    public void mkdir(String path) {
        navigate(path, true);
    }
    
    private String[] stripPathRootAndTokenize(String path) {
        return path.replaceFirst("/", "").split("/");
    }
    
    
    public void addContentToFile(String path, String content) {
        path.replaceFirst("/", "");
        String pathPart = path.substring(0, path.lastIndexOf("/"));
        String namePart = path.substring(path.lastIndexOf("/") + 1, path.length());
        File container = navigate(pathPart, false);
        if (container.children.containsKey(namePart)) {
            File existingFile = container.children.get(namePart);
            existingFile.content.add(content);
        } else {
            File newFile = new File(namePart, false, container);
            container.children.put(namePart, newFile);
            newFile.content.add(content);
        }
    }
    
    public String readContentFromFile(String path) {
        path.replaceFirst("/", "");
        String pathPart = path.substring(0, path.lastIndexOf("/"));
        String namePart = path.substring(path.lastIndexOf("/") + 1, path.length());
        File container = navigate(pathPart, false);
        File existingFile = container.children.get(namePart);
        return String.join("", existingFile.content);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */