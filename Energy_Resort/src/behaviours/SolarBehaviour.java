package behaviours;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;
import jade.core.Agent;
import agents.BaseAgent;
import agents.BatteryAgent;

 

 

public class SolarBehaviour extends OneShotBehaviour{
    
    ACLMessage msg;
    
    String msgData;
    
    public SolarBehaviour(Agent a) {
        super(a);
    }
    
    public SolarBehaviour(ACLMessage msg){
        try {
            this.msg = msg;
            this.msgData = msg.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void action() {
// ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
        
//        if (msg != null)
//        {
//            System.out.println(this.myAgent.getLocalName() +
//                     ": ho ricevuto un messaggio da " + msg.getSender().getLocalName() );
//                      System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
//                     System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
//            ACLMessage reply = msg.createReply();
//            AID receiver = new AID();
//            receiver.setLocalName("Battery");
//            reply.setContent("Ciao batteria!");
//            //reply.setPerformative(ACLMessage.INFORM);
//            reply.setConversationId("richiesta");
//            //System.out.println(reply);
//            this.myAgent.send(reply);
            System.out.println(this.myAgent.getLocalName() +
                         ": " + msg.getSender().getLocalName() + " dice: " + msgData);
                new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                        "pricesolar", "Non ho niente da venderti!");
                    //if(this.myAgent.getLocalName()=="Battery")
                    //{
                        
//                            ACLMessage reply = msg.createReply();
//                            AID receiver = new AID();
//                            receiver.setLocalName(msg.getSender().getLocalName());
//                            reply.setContent("Non ho niente da venderti!");
//                            reply.setPerformative(ACLMessage.INFORM);
//                            reply.setConversationId("energyrequest");
//                            //System.out.println(reply);
//                            this.myAgent.send(reply);
                    //}
    }
}