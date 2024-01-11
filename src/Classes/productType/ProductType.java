package Classes.productType;

import java.util.UUID;

    public class ProductType {

        private UUID id;

        private String name;

        private String description;

        public ProductType(String name, String description) {
            this.name = name;
            this.description = description;
            this.id = UUID.randomUUID();
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "ProductType{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
