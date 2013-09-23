fid = fopen('evo_p1/TSP1/GAp10i0.txt');
GAp10i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp10i1.txt');
GAp10i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp10i2.txt');
GAp10i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(GAp10i0);
GAp10=zeros(m,n);
for i=1:n
    GAp10(1,i)=(GAp10i0(1,i)+GAp10i1(1,i)+GAp10i2(1,i))/3;
    GAp10(2,i)= GAp10i0(2,i);
end
plot(GAp10(2,:),GAp10(1,:));
axis([2000 1000000 6 10])
hold all;
%figure(2);
fid = fopen('evo_p1/TSP1/GAp100i0.txt');
GAp100i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp100i1.txt');
GAp100i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp100i2.txt');
GAp100i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(GAp100i0);
GAp100=zeros(m,n);
for i=1:n
    GAp100(1,i)=(GAp100i0(1,i)+GAp100i1(1,i)+GAp100i2(1,i))/3;
    GAp100(2,i)= GAp100i0(2,i);
end
plot(GAp100(2,:),GAp100(1,:));
axis([2000 1000000 6 10])
%figure(3);
fid = fopen('evo_p1/TSP1/GAp1000i0.txt');
GAp1000i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp1000i1.txt');
GAp1000i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1/TSP1/GAp1000i2.txt');
GAp1000i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(GAp1000i0);
GAp1000=zeros(m,n);
for i=1:n
    GAp1000(1,i)=(GAp1000i0(1,i)+GAp1000i1(1,i)+GAp1000i2(1,i))/3;
    GAp1000(2,i)= GAp1000i0(2,i);
end
plot(GAp1000(2,:),GAp1000(1,:));
axis([2000 1000000 6 10])
legend('population=10','population=100','population=1000');
