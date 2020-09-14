/*
 * package behaviours;
 * 
 * import jade.core.AID; import jade.core.Agent; import
 * jade.core.behaviours.CyclicBehaviour; import
 * jade.core.behaviours.WakerBehaviour; import jade.lang.acl.ACLMessage; import
 * jade.lang.acl.MessageTemplate; import behaviours.AeolianBehaviour; import
 * data.AeolianData;
 * 
 * public class ReceiveMessagesAeolian extends CyclicBehaviour{
 * 
 * 
 * public ReceiveMessagesAeolian(Agent a){ super(a); }
 * 
 * public void action() {
 * 
 * 
 * ACLMessage msg =
 * this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
 * 
 * if (msg != null) { System.out.println(this.myAgent.getLocalName() +
 * ": ho ricevuto un messaggio da " + msg.getSender().getLocalName() );
 * System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
 * System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
 * 
 * 
 * ACLMessage reply = msg.createReply(); AID receiver = new AID();
 * receiver.setLocalName("Bungalow");
 * reply.setContent("Ho prodotto un sacco di roba");
 * reply.setPerformative(ACLMessage.INFORM); reply.addReceiver(receiver);
 * reply.setConversationId("richiesta"); this.myAgent.addBehaviour(new
 * WakerBehaviour(this.myAgent, 5000) { protected void onWake() {
 * this.myAgent.send(reply); } });
 * 
 * } else { this.block(); } }
 * 
 * }
 * 
 * 
 * 
 */