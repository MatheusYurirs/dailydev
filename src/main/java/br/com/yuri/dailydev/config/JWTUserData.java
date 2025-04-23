package br.com.yuri.dailydev.config;

public record JWTUserData(Long id,
                          String name,
                          String email) {

    public static class Builder{
        private Long id;
        private String name;
        private String email;

        public JWTUserData.Builder id(Long id){
            this.id = id;
            return this;
        }

        public JWTUserData.Builder name(String name){
            this.name = name;
            return this;
        }

        public JWTUserData.Builder email(String email){
            this.email = email;
            return this;

        }
        public JWTUserData build(){
            return new JWTUserData(id, name, email);
        }
    }

    public static JWTUserData.Builder builder(){
        return new JWTUserData.Builder();
    }
}
