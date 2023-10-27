import java.util.*;

class Candidate {
    private String name;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Voter {
    private String username;
    private String password;

    public Voter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class VotingSystem {
    private List<Candidate> candidates;
    private List<Voter> voters;
    private Map<Voter, Candidate> votes;

    public VotingSystem() {
        candidates = new ArrayList<>();
        voters = new ArrayList<>();
        votes = new HashMap<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void registerVoter(Voter voter) {
        voters.add(voter);
    }

    public void castVote(Voter voter, Candidate candidate) {
        if (voters.contains(voter) && candidates.contains(candidate)) {
            votes.put(voter, candidate);
            System.out.println(voter.getUsername() + " voted for " + candidate.getName());
        } else {
            System.out.println("Invalid voter or candidate.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<Voter, Candidate> entry : votes.entrySet()) {
            System.out.println(entry.getKey().getUsername() + " voted for " + entry.getValue().getName());
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        Candidate candidate1 = new Candidate("Candidate A");
        Candidate candidate2 = new Candidate("Candidate B");

        votingSystem.addCandidate(candidate1);
        votingSystem.addCandidate(candidate2);

        Voter voter1 = new Voter("user1", "password1");
        Voter voter2 = new Voter("user2", "password2");

        votingSystem.registerVoter(voter1);
        votingSystem.registerVoter(voter2);

        votingSystem.castVote(voter1, candidate1);
        votingSystem.castVote(voter2, candidate2);

        votingSystem.displayResults();
    }
}
