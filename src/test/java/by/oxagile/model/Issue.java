package by.oxagile.model;


import java.util.List;

public class Issue {
    private String summary;
    private List<String> labels;
    private List<String> linkedIssues;

    public String getSummary() {
        return summary;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public Issue withLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public List<String> getLinkedIssues() {
        return linkedIssues;
    }

    public Issue withLinkedIssues(List<String> linkedIssues) {
        this.linkedIssues = linkedIssues;
        return this;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "summary='" + summary + '\'' +
                ", labels=" + labels +
                ", linkedIssues=" + linkedIssues +
                '}';
    }
}


