public class MyTestingClass {
    private final String id;

    public MyTestingClass(String id) {
        this.id = id;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        for(int i=0;i<id.length();i++){
            hash = 31 * hash + id.charAt(i);
        }
        return hash;
    }
    @Override
    public String toString(){
        return "TestingClass{" + "id='" + id + '\'' + '}';
    }

}
