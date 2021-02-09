package Client;

import Client.Strategies.ClientSender;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private InetAddress serverIP;
    private int serverPort;
    private ClientSender clientStrategy;
    // private Socket theServer;

    public Client(InetAddress serverIP, int serverPort, ClientSender clientStrategy) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.clientStrategy = clientStrategy;
    }

    public void start() {
        try {
            //      theServer = new Socket(serverIP, serverPort);
            System.out.println(String.format("Client is connected to server (IP: %s, port: %s)", serverIP, serverPort));
//            clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String login(String userName, String password) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("Login," + userName + "," + password));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getAllTeams() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("getAllTeams,"));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getAllSeasons() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("getAllSeasons,"));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getAllLeagues() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("getAllLeagues,"));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getAllFields() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("getAllFields,"));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }


    public String availableSeasonsForTeam(String teamName) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            clientStrategy.setRequest(new StringBuilder("availableSeasonsForTeam," + teamName));
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String createTeam(String teamName, String league, String season, String field) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilderEditTeamProp(teamName, league, "createTeam,");
            req.append(",");
            req.append(season);
            req.append(",");
            req.append(field);
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getCoachesForTeamAtSeason(String teamName, String seasonYear) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilderEditTeamProp(teamName, seasonYear, "getCoachesForTeamAtSeason,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getTeamManagersForTeamAtSeason(String teamName, String seasonYear) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilderEditTeamProp(teamName, seasonYear, "getTeamManagersForTeamAtSeason,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getPlayersForTeamAtSeason(String teamName, String seasonYear) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilderEditTeamProp(teamName, seasonYear, "getPlayersForTeamAtSeason,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    private StringBuilder getStringBuilderEditTeamProp(String teamName, String seasonYear, String s) {
        StringBuilder req = new StringBuilder();
        req.append(s);
        req.append(teamName);
        req.append(",");
        req.append(seasonYear);
        return req;
    }

    public String getFieldsForTeamAtSeason(String teamName, String seasonYear) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilderEditTeamProp(teamName, seasonYear, "getFieldsForTeamAtSeason,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String editCoachDetails(String teamName, String seasonYear, String coachUserName,
                                   String coachFirstName, String coachLastName, String training, String role) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilder(teamName, seasonYear, coachUserName, coachFirstName, coachLastName, "editCoachDetails,");
            req.append(training);
            req.append(",");
            req.append(role);
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String editTeamManagerDetails(String teamName, String seasonYear, String teamManagerUserName, String teamManagerFirstName, String teamManagerLastName) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilder(teamName, seasonYear, teamManagerUserName, teamManagerFirstName, teamManagerLastName, "editTeamManagerDetails,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    private StringBuilder getStringBuilder(String teamName, String seasonYear, String teamPropUserName, String teamPropFirstName, String teamPropLastName, String s) {
        StringBuilder req = new StringBuilder();
        req.append(s);
        req.append(teamName);
        req.append(",");
        req.append(seasonYear);
        req.append(",");
        req.append(teamPropUserName);
        req.append(",");
        if(teamPropFirstName.isEmpty()){
            req.append("null");
            req.append(",");
        }
        else {
            req.append(teamPropFirstName);
            req.append(",");
        }
        if(teamPropLastName.isEmpty()){
            req.append("null");
            req.append(",");
        }
        else {
            req.append(teamPropLastName);
            req.append(",");
        }
        return req;
    }

    public String editPlayerDetails(String teamName, String seasonYear, String playerUserName, String playerFirstName, String playerLastName, String role) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilder(teamName, seasonYear, playerUserName, playerFirstName, playerLastName, "editPlayerDetails,");
            req.append(role);
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String editFieldDetails(String teamName, String seasonYear, String fieldName, String city, String capacity) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = getStringBuilder(teamName, seasonYear, fieldName, city, capacity, "editFieldDetails,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String getGameIds() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("getGameIds,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String exportGameReport(int gameID, String absolutePath, String fileName) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("exportGameReport,");
            req.append(gameID);
            req.append(",");
            req.append(absolutePath);
            req.append(",");
            req.append(fileName);
            req.append(",");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String addEvent(int gameID, String eventType, String description) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("addEvent,");
            req.append(gameID);
            req.append(",");
            req.append(eventType);
            req.append(",");
            req.append(description);
            req.append(",");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String defineGameSchedulingPolicy(String policy, String league, String season) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("defineGameSchedulingPolicy,");
            req.append(policy);
            req.append(",");
            req.append(league);
            req.append(",");
            req.append(season);
            req.append(",");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String defineScoreTablePolicy(String policy, String league, String season) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("defineScoreTablePolicy,");
            req.append(policy);
            req.append(",");
            req.append(league);
            req.append(",");
            req.append(season);
            req.append(",");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String checkNotification() {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("checkNotification,");
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            System.out.println(req.toString());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    public String availableSeasonsForLeague(String toString) {
        String ans = null;
        try {
            Socket theServer = new Socket(serverIP, serverPort);
            StringBuilder req = new StringBuilder("availableSeasonsForLeague,"+toString);
            clientStrategy.setRequest(req);
            ans = clientStrategy.clientStrategy(theServer.getInputStream(), theServer.getOutputStream());
            theServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
