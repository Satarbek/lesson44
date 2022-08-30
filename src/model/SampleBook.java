package model;

public class SampleBook {

        private String name;
        private String status;
        private String description;
        private String reader;

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public String getDescription() {
            return description;
        }

        public String getReader() {
            return reader;
        }

    public SampleBook(String name, String status, String description, String reader) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.reader = reader;
    }

    public SampleBook(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
