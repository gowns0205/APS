# [Silver V] 크로아티아 알파벳 - 2941 

[문제 링크](https://www.acmicpc.net/problem/2941) 

### 성능 요약

메모리: 17596 KB, 시간: 204 ms

### 분류

구현(implementation), 문자열(string)

### 문제 설명

<p style="user-select: auto;">예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.</p>

<table class="table table-bordered table-center-20 th-center td-center" style="user-select: auto;">
	<thead style="user-select: auto;">
		<tr style="user-select: auto;">
			<th style="user-select: auto;">크로아티아 알파벳</th>
			<th style="user-select: auto;">변경</th>
		</tr>
	</thead>
	<tbody style="user-select: auto;">
		<tr style="user-select: auto;">
			<td style="user-select: auto;">č</td>
			<td style="user-select: auto;">c=</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">ć</td>
			<td style="user-select: auto;">c-</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">dž</td>
			<td style="user-select: auto;">dz=</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">đ</td>
			<td style="user-select: auto;">d-</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">lj</td>
			<td style="user-select: auto;">lj</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">nj</td>
			<td style="user-select: auto;">nj</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">š</td>
			<td style="user-select: auto;">s=</td>
		</tr>
		<tr style="user-select: auto;">
			<td style="user-select: auto;">ž</td>
			<td style="user-select: auto;">z=</td>
		</tr>
	</tbody>
</table>

<p style="user-select: auto;">예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.</p>

<p style="user-select: auto;">dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.</p>

### 입력 

 <p style="user-select: auto;">첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.</p>

<p style="user-select: auto;">단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.</p>

### 출력 

 <p style="user-select: auto;">입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.</p>

