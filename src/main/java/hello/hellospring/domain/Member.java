package hello.hellospring.domain;

public class Member {

    private Long id;    // 임의의 값. 시스템이 규별하기 위해 저장하는 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
