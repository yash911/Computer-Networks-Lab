set ns [new Simulator]
set tf [open out.tr w]
set nf [open sim2.nam w]

proc finish {} {
	global ns tf nf
	$ns flush-trace
	close $tf
	close $nf
	exit 0
	}

$ns trace-all $tf
$ns namtrace-all $nf
set node0 [$ns node]
set node1 [$ns node]
set node2 [$ns node]
set node3 [$ns node]
set node4 [$ns node]

$ns duplex-link $node0 $node2 1Mb 10ms DropTail
$ns duplex-link $node1 $node4 1Mb 10ms DropTail
$ns duplex-link $node0 $node3 1Mb 10ms DropTail
$ns duplex-link $node3 $node2 1Mb 10ms DropTail
$ns duplex-link $node4 $node3 1Mb 10ms DropTail

$ns queue-limit $node0 $node2 2
$ns queue-limit $node1 $node4 2
$ns queue-limit $node0 $node3 2
$ns queue-limit $node3 $node2 2
$ns queue-limit $node4 $node3 2

Agent/Ping instproc recv {from rtt} {
	$self instvar node_
	puts "node {node_id} recieved ping answer from $from with return trip time $rtt ms"
}

set c1 [$ns create-connection Ping $node0 Ping $node2 1]
set c2 [$ns create-connection Ping $node1 Ping $node4 2]
set c3 [$ns create-connection Ping $node0 Ping $node3 3]
set c4 [$ns create-connection Ping $node3 Ping $node2 4]
set c5 [$ns create-connection Ping $node4 Ping $node3 5]

for {set i 1} {$i<=10} {incr i} {
	$ns at [expr $i/10] "$c1 send"
	$ns at [expr $i/10] "$c2 send"
	$ns at [expr $i/10] "$c3 send"
	$ns at [expr $i/10] "$c4 send"
	$ns at [expr $i/10] "$c5 send"
	}
$ns at 10 "finish"
$ns run 
