fid = fopen('evo_p1old/TSP1/BS10i0.txt');
BS10i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS10i1.txt');
BS10i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS10i2.txt');
BS10i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(BS10i0);
BS10=zeros(m,n);
for i=1:n
    BS10(1,i)=(BS10i0(1,i)+BS10i1(1,i)+BS10i2(1,i))/3;
    BS10(2,i)= BS10i0(2,i);
end
plot(BS10(2,:),BS10(1,:));
axis([2000 1000000 6 10])
hold all;
%figure(2);
fid = fopen('evo_p1old/TSP1/BS100i0.txt');
BS100i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS100i1.txt');
BS100i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS100i2.txt');
BS100i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(BS100i0);
BS100=zeros(m,n);
for i=1:n
    BS100(1,i)=(BS100i0(1,i)+BS100i1(1,i)+BS100i2(1,i))/3;
    BS100(2,i)= BS100i0(2,i);
end
plot(BS100(2,:),BS100(1,:));
axis([2000 1000000 6 10])
%figure(3);
fid = fopen('evo_p1old/TSP1/BS1000i0.txt');
BS1000i0 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS1000i1.txt');
BS1000i1 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
fid = fopen('evo_p1old/TSP1/BS1000i2.txt');
BS1000i2 = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
[m,n] = size(BS1000i0);
BS1000=zeros(m,n);
for i=1:n
    BS1000(1,i)=(BS1000i0(1,i)+BS1000i1(1,i)+BS1000i2(1,i))/3;
    BS1000(2,i)= BS1000i0(2,i);
end
plot(BS1000(2,:),BS1000(1,:));
axis([2000 1000000 6 10])
legend('population=10','population=100','population=1000');

