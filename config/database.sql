-- Create a User using phpMyAdmin with Host:"localhost" and tick at "Create database with same name and grant all privileges."


CREATE TABLE IF NOT EXISTS `User` (
  `id` int(10) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`id`, `name`, `email`, `password`) VALUES
(1, 'oronno', 'oronno@oneous.com', 'asdasd'),
(2, 'Sakib', 'sakib@gmail.com', 'asdasd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`id`);
