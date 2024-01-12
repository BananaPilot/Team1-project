package classes.productType;

import java.util.UUID;

    public class ProductType {

        private String ID;

        private String name;

        private String description;

        public ProductType(String name, String description) {
            this.name = name;
            this.description = description;
            this.ID = UUID.randomUUID().toString();
        }

        public String getID() {
            return ID;
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
                    "ID=" + ID +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
