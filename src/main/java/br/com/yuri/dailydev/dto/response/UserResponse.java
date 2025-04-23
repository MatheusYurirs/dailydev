package br.com.yuri.dailydev.dto.response;

public record UserResponse(Long id,
                           String name,
                           String email) {
    public static class Builder{
        private Long id;
        private String name;
        private String email;

        public UserResponse.Builder id(Long id){
            this.id = id;
            return this;
        }

        public UserResponse.Builder name(String name){
            this.name = name;
            return this;
        }

        public UserResponse.Builder email(String email){
            this.email = email;
            return this;

        }
        public UserResponse build(){
            return new UserResponse(id, name, email);
        }
    }

    public static UserResponse.Builder builder(){
        return new UserResponse.Builder();
    }
}
