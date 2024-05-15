public class MyTestingClass {
    private String age;
    public MyTestingClass(String age){
        this.age = age;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass myTestingClass = (MyTestingClass) o;
        return age.equals(myTestingClass.age);

    }
    @Override
    public int hashCode(){
        int hash = 4;
        for(int i=0;i<age.length();i++){
            hash += 62*hash+age.charAt(i);
        }
        return Math.abs(hash%11);
    }
    @Override
    public String toString(){
        return "MytestingClass:{" + "age=" + age + "}";
    }
}
