package by.oxagile.model;


import java.util.List;

public class Issue {
    private String summary;
    private List<String> labels;
    private List<String> linkedIssues;

    public Issue(String summary, List<String> labels, List<String> linkedIssues) {
        this.summary = summary;
        this.labels = labels;
        this.linkedIssues = linkedIssues;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getLinkedIssues() {
        return linkedIssues;
    }

    public void setLinkedIssues(List<String> linkedIssues) {
        this.linkedIssues = linkedIssues;
    }
}
