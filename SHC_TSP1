fid = fopen('evo_p1hc/TSP1/SHCi0.txt');
SHCi0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1hc/TSP1/SHCi1.txt');
SHCi1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1hc/TSP1/SHCi2.txt');
SHCi2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
plot(SHCi0(2,:),SHCi0(1,:));
axis([0 2000000 19 22])
hold all;
plot(SHCi1(2,:),SHCi1(1,:));
plot(SHCi2(2,:),SHCi2(1,:));
legend('Run 1','Run 2','Run 3');
