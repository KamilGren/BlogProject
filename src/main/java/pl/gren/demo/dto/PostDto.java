package pl.gren.demo.dto;

import pl.gren.demo.model.User;

public class PostDto {
        private int id;
        private String content;
        private String title;

        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
}
