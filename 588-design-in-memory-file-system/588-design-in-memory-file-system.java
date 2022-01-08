class File {
    String name;
    boolean isDirectory;
    StringBuilder content;
    TreeMap<String, File> children;
    File parent;
    public File(String name, boolean isDirectory, File parent) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.content = new StringBuilder();
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
        File target = navigate(path, false);
        List<String> result = new ArrayList<>();
        if (target.isDirectory) for (String name : target.children.keySet()) result.add(name);
        else result.add(target.name);
        return result;
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
    
    private String[] splitDirAndFile(String path) {
        String pathPart = path.substring(0, path.lastIndexOf("/"));
        String namePart = path.substring(path.lastIndexOf("/") + 1, path.length());
        return new String[]{pathPart, namePart};
    }
    
    public void addContentToFile(String path, String content) {
        String[] splitPath = splitDirAndFile(path);
        File container = navigate(splitPath[0], false);
        
        File file;
        if (container.children.containsKey(splitPath[1])) {
            file = container.children.get(splitPath[1]);
        } else {
            file = new File(splitPath[1], false, container);
            container.children.put(splitPath[1], file);
        }
        file.content.append(content);
    }
    
    public String readContentFromFile(String path) {
        String[] splitPath = splitDirAndFile(path);
        File container = navigate(splitPath[0], false);
        File file = container.children.get(splitPath[1]);
        return file.content.toString();
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