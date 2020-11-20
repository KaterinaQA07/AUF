package models;

public class ProjectBuilder {
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private int typeOfProject;
    private boolean isCompleted;

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public int getTypeOfProject() {
        return typeOfProject;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public static Builder newBuilder() {
        return new ProjectBuilder().new Builder();
    }
    public class Builder {
        private Builder() {
        }

        public Builder setName(String name) {
            ProjectBuilder.this.name = name;

            return this;
        }

        public Builder setAnnouncement(String announcement) {
            ProjectBuilder.this.announcement = announcement;

            return this;
        }

        public Builder setShowAnnouncement(boolean value) {
            ProjectBuilder.this.isShowAnnouncement = value;

            return this;
        }

        public Builder setTypeOfProject(int value) {
            ProjectBuilder.this.typeOfProject = value;

            return this;
        }

        public Builder setCompleted(boolean value) {
            ProjectBuilder.this.isCompleted = value;

            return this;
        }

        public ProjectBuilder build() {
            return ProjectBuilder.this;
        }
    }
}