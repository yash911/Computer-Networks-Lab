BEGIN {
	count=0;
}
{
if($1=="d")
	count++;
}
END {
	printf("no of packets dropped =%d\n"+count);
}
