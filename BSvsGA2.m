bestGAp10i=zeros(10,2,1000);
for i=0:9
fid = fopen(strcat('evo_p1/bestGAp10i',int2str(i),'.txt'));
bestGAp10i(i+1,:,:) = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
end
[m,n] = size(bestGAp10i(1,:));

for j=1:10
	bestGAp10(j,:)=bestGAp10i(j,1,:);
end
boxplot(bestGAp10(1:3,1:1000));
set(gca,'XTickLabel',{' '});
hold on;

for i=0:9
fid = fopen(strcat('evo_p1old/BS1000i',int2str(i),'.txt'));
BS1000i(i+1,:,:) = fscanf(fid, '%g|%d', [2 inf]);
fclose(fid);
end
[m,n] = size(BS1000i(1,:));

for j=1:10
	BS1000(j,:)=BS1000i(j,1,:);
end
boxplot(BS1000(1:3,1:999));
%axis([0 25 6 18]);
