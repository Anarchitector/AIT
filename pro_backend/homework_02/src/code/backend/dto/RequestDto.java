package code.backend.dto;

public class RequestDto {
    private String name;
    private String description;
    private Integer id;

    public RequestDto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public RequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
